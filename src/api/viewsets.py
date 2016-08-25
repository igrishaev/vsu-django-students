from rest_framework import viewsets
from rest_framework.decorators import detail_route
from rest_framework.response import Response


from api import serializers
from students import models

__all__ = (
    'GroupViewSet',
    'StudentViewSet',
)


class StudentViewSet(viewsets.ReadOnlyModelViewSet):

    queryset = models.Student.objects.all()
    serializer_class = serializers.StudentSerializer


class GroupViewSet(viewsets.ReadOnlyModelViewSet):

    queryset = models.Group.objects.all()
    serializer_class = serializers.GroupSerializer

    @detail_route()
    def students(self, request, pk):

        group = self.get_object()

        context = {
            'request': request
        }

        serializer = serializers.StudentSerializer(
            group.students, many=True, context=context)

        return Response(serializer.data)
