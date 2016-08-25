docker-build:
	docker build -t vsu-django:test .

docker-run:
	docker run -it --rm -p 8080:8080 -v $(CURDIR):/app vsu-django:test $(cmd)

app-serve:
	src/manage.py runserver 0.0.0.0:8080

app-shell:
	src/manage.py shell
