from rest_framework import routers

from api import viewsets


router = routers.SimpleRouter()

router.register(r'groups', viewsets.GroupViewSet, 'groups')
router.register(r'students', viewsets.StudentViewSet, 'students')

urlpatterns = router.urls
