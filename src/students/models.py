from django.db import models

__all__ = (
    'Group',
    'Student'
)

MAX_LEN = 255

COURSE_CHOICES = [(x, x) for x in range(1, 6)]
EDU_FORM_CHOICES = [
    ('full-fime', 'Очная'),
    ('part-fime', 'Заочная'),
]
EDU_LEVEL_CHOICES = [
    ('low', 'Низший'),
    ('mid', 'Средний'),
    ('high', 'Высший'),
]


class Group(models.Model):
    title = models.CharField(max_length=MAX_LEN)
    subtitle = models.CharField(max_length=MAX_LEN)
    edu_form = models.CharField(max_length=MAX_LEN, choices=EDU_FORM_CHOICES)
    number = models.IntegerField()
    course = models.IntegerField(choices=COURSE_CHOICES)
    edu_level = models.CharField(max_length=MAX_LEN, choices=EDU_LEVEL_CHOICES)


class Student(models.Model):
    first_name = models.CharField(max_length=MAX_LEN)
    last_name = models.CharField(max_length=MAX_LEN)
    patronymic_name = models.CharField(max_length=MAX_LEN)
    date_birth = models.DateField()
    group = models.ForeignKey(Group)
    course = models.CharField(max_length=MAX_LEN, choices=COURSE_CHOICES)
