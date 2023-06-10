package io.nopecho.utils;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;

public class LongIdGenerator {
    private static final int UNUSED_BITS = 1; // Sign bit, Unused (always set to 0)
    private static final int EPOCH_BITS = 41;
    private static final int NODE_ID_BITS = 10;
    private static final int SEQUENCE_BITS = 12;

    private static final long maxNodeId = (1L << NODE_ID_BITS) - 1;
    private static final long nodeId = createNodeId();
    private static final long maxSequence = (1L << SEQUENCE_BITS) - 1;
    // Custom Epoch (January 1, 2015 Midnight UTC = 2015-01-01T00:00:00Z)
    private static final long DEFAULT_CUSTOM_EPOCH = 1420070400000L;
    private static final long customEpoch = DEFAULT_CUSTOM_EPOCH;

    private static final AtomicLong lastTimestamp = new AtomicLong(-1L);
    private static final AtomicLong sequence = new AtomicLong(0L);


    public static synchronized long gen() {
        long currentTimestamp = timestamp();

        if (currentTimestamp < lastTimestamp.get()) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp.get()) {
            sequence.compareAndSet(sequence.get(), (sequence.get() + 1) & maxSequence);
            if (sequence.get() == 0) {
                // Sequence Exhausted, wait till next millisecond.
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // reset sequence to start with zero for the next millisecond
            sequence.set(0);
        }

        lastTimestamp.set(currentTimestamp);

        long id = currentTimestamp << (NODE_ID_BITS + SEQUENCE_BITS)
                | (nodeId << SEQUENCE_BITS)
                | sequence.get();

        return id;
    }


    // Get current timestamp in milliseconds, adjust for the custom epoch.
    private static long timestamp() {
        return Instant.now().toEpochMilli() - customEpoch;
    }

    // Block and wait till next millisecond
    private static long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp.get()) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }

    private static long createNodeId() {
        long nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for (byte macPort : mac) {
                        sb.append(String.format("%02X", macPort));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        nodeId = nodeId & maxNodeId;
        return nodeId;
    }
}
