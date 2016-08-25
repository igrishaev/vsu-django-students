from rest_framework import routers

from api import viewsets


router = routers.SimpleRouter()
router.register(r'students', viewsets.StudentViewSet)

urlpatterns = router.urls
