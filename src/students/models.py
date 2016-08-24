from django.db import models

__all__ = (
    'Group',
    'Student'
)


class Group(models.Model):
    title = models.
    subtitle = models.
    edu_form = models.
    number = models.
    course = models.
    edu_level = models.


class Student(models.Model):
    first_name =
    last_name =
    patronymic_name =
    date_birth = models.DateField()
    group = models.ForeignKey(Group)
    course = models.
