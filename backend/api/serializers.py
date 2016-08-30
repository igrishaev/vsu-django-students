
from rest_framework import serializers

from students import models

__all__ = (
    'StudentSerializer',
    'GroupSerializer',
)


class GroupSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Group

    edu_form = serializers.SerializerMethodField()
    edu_level = serializers.SerializerMethodField()

    def get_edu_form(self, obj):
        return obj.get_edu_form_display()

    def get_edu_level(self, obj):
        return obj.get_edu_level_display()


class StudentSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Student

    group = GroupSerializer()
