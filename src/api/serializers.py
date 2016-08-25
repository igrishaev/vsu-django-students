
from rest_framework import serializers

from students import models

__all__ = (
    'StudentSerializer',
    'GroupSerializer',
)


class StudentSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Student
        # fields = ('id', 'account_name', 'users', 'created')


class GroupSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Group
        # fields = ('id', 'account_name', 'users', 'created')
