FROM python:3

ENV PYTHONDONTWRITEBYTECODE 1
EXPOSE 8080 9191

COPY pip.requirements* /app/
WORKDIR /app
RUN pip install -r pip.requirements.txt
RUN rm pip.requirements*

COPY backend /app/
RUN ./manage.py migrate
RUN ./manage.py students_gen_models

CMD ["uwsgi", "uwsgi.ini"]
