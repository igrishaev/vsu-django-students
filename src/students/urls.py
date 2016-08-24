from rest_framework import routers

from students import viewsets


router = routers.SimpleRouter()
router.register(r'students', viewsets.StudentsViewSet)

urlpatterns = router.urls
