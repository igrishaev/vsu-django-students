docker-build-prod:
	docker build -t vsu-django:prod .

docker-build-test:
	docker build -t vsu-django:test -f Dockerfile-dev .

docker-run-prod:
	docker run -it --rm -p 8080:8080 -p 9191:9191 vsu-django:prod $(cmd)

docker-run-test:
	docker run -it --rm -p 8080:8080 -p 9191:9191 -v $(CURDIR):/app vsu-django:test $(cmd)

app-serve:
	backend/manage.py runserver 0.0.0.0:8080

app-gen-models:
	backend/manage.py students_gen_models

app-shell:
	backend/manage.py shell
