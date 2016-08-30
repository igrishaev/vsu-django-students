from functools import partial

from django.conf.urls import url, include
from django.contrib import admin

from django.shortcuts import redirect

index = partial(redirect, "/static/index.html")

urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^api/', include('api.urls')),
    url(r'^$', index),
]

from django.conf import settings
from django.conf.urls.static import static

urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
