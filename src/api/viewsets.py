from rest_framework import viewsets

from api import serializers
from students import models

__all__ = (
    'StudentViewSet',
)


class StudentViewSet(viewsets.ReadOnlyModelViewSet):

    queryset = models.Student.objects.all()
    serializer_class = serializers.StudentSerializer
