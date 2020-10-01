# HoA [Not very useful. Just for practice]
House of Anime application!

hoa-services is a multi-module maven project. Each of these modules can be built separately.
-> hoa-series-service contains REST APIs for anime series.
-> hoa-manga-service contains REST APIs for manga.
-> hoa-service includes both of the above modules.

Each of these modules contains two sub-modules, core and main.
-> Core module contains most of the source files (for controller, models, repositories and services)
-> Main module contains the main function and the yaml file for configuration. (application.yml) Postgres database is configured in the same file. 

Dependencies:
* Spring web
* Data JPA
* Postgres driver
* devtools
