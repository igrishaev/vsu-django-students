from rest_framework import viewsets

from students import models

__all__ = (
    'StudentViewSet',
)


class StudentViewSet(viewsets.ReadOnlyModelViewSet):

    queryset = models.Student.objects.all()
    # serializer_class = UserSerializer
