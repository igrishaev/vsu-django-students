
from datetime import datetime

import factory
import factory.fuzzy

__all__ = (
    'GroupFactory',
    'StudentFactory',
)


class GroupFactory(factory.django.DjangoModelFactory):

    class Meta:
        model = 'students.Group'

    number = factory.Sequence(lambda n: n)
    title = factory.Faker('text')
    subtitle = factory.Faker('text')
    course = factory.fuzzy.FuzzyInteger(1, 5)
    # edu_form =


class StudentFactory(factory.django.DjangoModelFactory):

    class Meta:
        model = 'students.Student'

    date_birth = factory.fuzzy.FuzzyDate(datetime(1980, 1, 1),
                                         datetime(2005, 1, 1))
    course = factory.fuzzy.FuzzyInteger(1, 5)
    first_name = factory.Faker('first_name')
    last_name = factory.Faker('last_name')
