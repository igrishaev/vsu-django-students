FROM python:3

ENV PYTHONDONTWRITEBYTECODE 1

COPY pip.requirements* /app/
WORKDIR /app
RUN pip install -r pip.requirements.txt
RUN rm pip.requirements*

WORKDIR /app/backend
CMD ["uwsgi", "uwsgi.ini"]
