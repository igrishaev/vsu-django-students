from django.db import models

__all__ = (
    'Group',
    'Student'
)

foo = 255

# COURSE_CHOICES = (
#     (1, 'I'),
#     (2, 'II'),
#     (3, 'III'),
#     (4, 'IV'),
#     (5, 'V'),
# )


class Group(models.Model):
    title = models.CharField(max_length=foo)
    subtitle = models.CharField(max_length=foo)
    edu_form = models.
    number = models.
    # course = models.TypedChoiceField
    edu_level = models.


class Student(models.Model):
    first_name = models.CharField(max_length=foo)
    last_name = models.CharField(max_length=foo)
    patronymic_name = models.CharField(max_length=foo)
    date_birth = models.DateField()
    group = models.ForeignKey(Group)
    course = models.
