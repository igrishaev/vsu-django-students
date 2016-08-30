
from datetime import datetime
from functools import partial

import factory
import factory.fuzzy

from students import models

__all__ = (
    'GroupFactory',
    'StudentFactory',
)

Faker = partial(factory.Faker, locale='ru_RU')


class GroupFactory(factory.django.DjangoModelFactory):

    class Meta:
        model = 'students.Group'

    number = factory.Sequence(lambda n: n)
    title = Faker('company')
    subtitle = Faker('text')
    course = factory.fuzzy.FuzzyChoice([x for (x, y) in models.COURSE_CHOICES])
    edu_form = factory.fuzzy.FuzzyChoice([x for (x, y) in models.EDU_FORM_CHOICES])
    edu_level = factory.fuzzy.FuzzyChoice([x for (x, y) in models.EDU_LEVEL_CHOICES])


class StudentFactory(factory.django.DjangoModelFactory):

    class Meta:
        model = 'students.Student'

    date_birth = factory.fuzzy.FuzzyDate(datetime(1980, 1, 1),
                                         datetime(2005, 1, 1))
    course = factory.fuzzy.FuzzyChoice([x for (x, y) in models.COURSE_CHOICES])
    first_name = Faker('first_name_male')
    last_name = Faker('last_name_male')
    patronymic_name = Faker('prefix_male')
