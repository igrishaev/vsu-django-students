
import random

from students import factories
from students import models

from django.core.management import BaseCommand


class Command(BaseCommand):

    def handle(self, *args, **options):

        models.Student.objects.all().delete()
        models.Group.objects.all().delete()

        group_list = [factories.GroupFactory.create() for x in range(20)]
        student_list = [factories.StudentFactory.create(
            group=random.choice(group_list)
        ) for x in range(400)]
