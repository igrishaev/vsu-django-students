docker-build:
	docker build -t vsu-django:test .

docker-run:
	docker run -it --rm -p 8080:8080 -p 9191:9191 -v $(CURDIR):/app vsu-django:test $(cmd)

app-serve:
	backend/manage.py runserver 0.0.0.0:8080

app-gen-models:
	backend/manage.py students_gen_models

app-shell:
	backend/manage.py shell

# cljs-build:
# 	boot -s ./frontend cljs target -d ../backend/static

# server-prepare:
# 	git clone https://github.com/igrishaev/vsu-django-students
# 	cd vsu-django-students
# 	mkvirtualenv --python=/usr/bin/python3.5 students
# 	workon students
# 	pip install -r pip.requirements.txt
