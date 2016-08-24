docker-build:
	docker build -t vsu-django:test .

docker-run:
	docker run -it --rm -p 8080:8080 -v $(CURDIR):/app vsu-django:test $(cmd)
