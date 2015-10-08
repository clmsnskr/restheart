**WARNING** this `develop` branch is abandoned, please use the [`master` branch](https://github.com/SoftInstigate/restheart/tree/master) only for your Pull Requests.

>At present RESTHeart's Git repo is organized mimicking Gitflow, but this kind of code organization is not regarded as a good practice for products. We do have a "develop" branch with SNAPSHOT and a "master" with final releases. Now we have reached 1.0.0 and we need to support a more functional organization of code to support future versions and their maintenance.

# New branching policy

There are two outstanding examples to follow:
1. https://github.com/spring-projects/spring-boot/
1. https://github.com/undertow-io/undertow/

These projects have one "master" where all the new code is committed (unreleased versions) while released versions are tagged and then maintained in their own branches (named `1.0.x`, `1.1.x`, `1.2.x`, ....)

## Process

1. As soon as a minor release is finalized (e.g we released `1.0.0`) we tag it on `master`
1. we create the related support branch, in this case named `1.0.x`, with version set to `1.0.1-SNAPSHOT`. Hotfixes for `1.0.x` will go here.
1. The master branch is the where `1.1.x` development begins, and the POM version is set at `1.1.0-SNAPSHOT`
1. When `1.1.0` is final, the process starts again from 1.

# RESTHeart #

The data REST API server for MongoDB.

Open your data, quickly build HATEOAS applications, use it as your mobile apps back-end,...

__You'll find the full documentation at [http://www.restheart.org](http://www.restheart.org).__

Develop branch:

[![Build Status](https://travis-ci.org/SoftInstigate/restheart.svg?branch=develop)](https://travis-ci.org/SoftInstigate/restheart)

## RESTHeart is the REST API server for [MongoDB](http://www.mongodb.org/).

* Zero development time: just start it and the data REST API is ready to use
* CRUD operations API on your data
* Data model operations API: create dbs, collections, indexes and the data structure
* Super easy setup with convention over configuration approach
* Pluggable security with User Management and ACL
* [HAL](http://stateless.co/hal_specification.html) hypermedia type
* Super lightweight: pipeline architecture, ~7Mb footprint, ~200Mb RAM peek usage, starts in milliseconds,..
* High throughput: very small overhead on MongoDB performance
* Horizontally scalable: fully stateless architecture supporting MongoDB replica sets and shards
* Built on top of [Undertow](http://undertow.io) non-blocking web server
* Embeds the excellent [HAL browser](https://github.com/mikekelly/hal-browser) by Mike Kelly (the author of the HAL specifications)
* Support Cross-origin resource sharing ([CORS](http://en.wikipedia.org/wiki/Cross-origin_resource_sharing)) so that your one page web application can deal with RESTHeart running on a different domain. In other words, CORS is an evolution of JSONP
* Ideal as a [AngularJS](https://angularjs.org) (or any other MVW javascript framework) back-end

## How to run it

### Vagrant

If you don’t want to install and run all the components manually on your host, there is a handy [Vagrant box](https://github.com/SoftInstigate/restheart-vagrant) available for creating a complete virtual development environment, using a Ubuntu 14.04 image with JDK 8, MongoDB 3 and the latest RESTHeart server. You can then skip section 2 to 6 and jump directly to section 7, in case you want to know how to change the default security settings.

### Docker

Docker is even simpler. There is a [Docker container](https://hub.docker.com/r/softinstigate/restheart/) with a JVM running RESTHeart, linked to another container running MongoDB, which makes use of the official MongoDB image.

### Bare metal

Please follow the next sections for a full local installation.

> RESTHeart requires [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html), make sure you have it and available on your path. It builds with [Maven](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

Download the latest release from [github releases page](https://github.com/SoftInstigate/restheart/releases/latest), unpack the archive and just run the jar.

	$ java -server -jar restheart.jar

You might also want to specify a configuration file:

	$ java -server -jar restheart.jar etc/restheart.yml

* configuration file [documentation](http://restheart.org/docs/configuration.html)
* example configuration file [restheart.yml](http://restheart.org/docs/configuration.html#conf-example)

## How to build it

Clone the repository and update the git submodules (the HAL browser is included in restheart as a submodule):

    $ git submodule update --init --recursive

Build the project with maven

    $ mvn clean package

Optionally run the integration test suite (make sure mongod is running on localhost on default port 27017 without authentication, i.e. no --auth option specified)

    $ mvn verify
