LOCAL_DB_PORT ?= 5433
LOCAL_DB_NAME ?= nopecho
LOCAL_DB_PASSWORD ?= nopecho
LOCAL_DB_USER := $(LOCAL_DB_NAME)
LOCAL_DB_CONTAINER := local-$(LOCAL_DB_NAME)
RUNNING_DB_CONTAINER := $(shell docker ps -f name=$(LOCAL_DB_CONTAINER) --format "{{.Names}}")

help: ## show help message
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[$$()% 0-9a-zA-Z_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

stop-db: ## Stop DB Docker Container
ifeq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	@docker stop $(LOCAL_DB_CONTAINER)
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is not running"
endif

start-db: ## Start DB Docker Container
ifneq ($(RUNNING_DB_CONTAINER),$(LOCAL_DB_CONTAINER))
	@docker run --rm --name $(LOCAL_DB_CONTAINER) -d \
	-v ${PWD}/schema:/docker-entrypoint-initdb.d \
	-p $(LOCAL_DB_PORT):5432 \
	-e POSTGRES_PASSWORD="$(LOCAL_DB_PASSWORD)" \
	-e POSTGRES_USER="$(LOCAL_DB_USER)" \
	-e POSTGRES_DB="$(LOCAL_DB_NAME)"  \
	postgres:13-alpine
else
	@echo "DB($(LOCAL_DB_CONTAINER)) is Already running."
endif

clean:
	@find . -type d -name "out" -exec rm -rf {} +