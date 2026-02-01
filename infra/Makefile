# -----------------------------
# Global infra Makefile (dev)
# -----------------------------

COMPOSE = docker compose

TRAEFIK_DIR = traefik
MEILI_DIR   = meilisearch

.PHONY: help up down restart logs ps clean \
        traefik-up traefik-down traefik-logs \
        meili-up meili-down meili-logs meili-clean \
        status

help:
	@echo ""
	@echo "Infra targets:"
	@echo "  make up            Start all infra services"
	@echo "  make down          Stop all infra services"
	@echo "  make restart       Restart all infra services"
	@echo "  make status        Show container status"
	@echo ""
	@echo "Traefik:"
	@echo "  make traefik-up    Start Traefik"
	@echo "  make traefik-down  Stop Traefik"
	@echo "  make traefik-logs  Tail Traefik logs"
	@echo ""
	@echo "Meilisearch:"
	@echo "  make meili-up      Start Meilisearch"
	@echo "  make meili-down    Stop Meilisearch"
	@echo "  make meili-logs    Tail Meilisearch logs"
	@echo "  make meili-clean   Stop + remove Meili volumes"
	@echo ""

# -----------------------------
# Top-level orchestration
# -----------------------------

up: traefik-up meili-up

down: meili-down traefik-down

restart: down up

status:
	$(COMPOSE) ps

logs:
	$(COMPOSE) logs -f

clean: meili-clean traefik-down

# -----------------------------
# Traefik
# -----------------------------

traefik-up:
	cd $(TRAEFIK_DIR) && $(COMPOSE) up -d

traefik-down:
	cd $(TRAEFIK_DIR) && $(COMPOSE) down

traefik-logs:
	cd $(TRAEFIK_DIR) && $(COMPOSE) logs -f traefik

# -----------------------------
# Meilisearch
# -----------------------------

meili-up:
	cd $(MEILI_DIR) && $(COMPOSE) up -d

meili-down:
	cd $(MEILI_DIR) && $(COMPOSE) down

meili-logs:
	cd $(MEILI_DIR) && $(COMPOSE) logs -f meilisearch

meili-clean:
	cd $(MEILI_DIR) && $(COMPOSE) down -v
