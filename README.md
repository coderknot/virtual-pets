# _Virtual Pets_

#### _Java Project for Epicodus - Week Four 2017_

#### By _**Grace Stuart (gstuart) and Chris Carr (coderknot)**_

## Description
> A version of the old school virtual pets where a user can experience different interactions with their pets, such as feeding them, putting them to bed, or playing with them.

## Setup/Installation Requirements
1. Install Java JRE (Runtime Enviornment).
2. Install Postgres.
3. Install Gradle.
4. Clone this repository onto your desktop. This will place the all files and folders in onto your computer.
5. Start Postgres in an additional terminal tab, and psql in yet another.
6. In psql tab enter `CREATE DATABASE virtual_pets;`
7. In terminal tab enter `psql media < media.sql`
8. In psql tab enter `\c virtual_pets` then `\dt`
9. In terminal tab enter `gradle run`
10. Navigate to 0.0.0.0:4567 in your internet browser

## Know Bugs
> No known bugs.

## Technology Used To Create Portfolio
* Java
* JUnit
* Gradle

## Specifications
|Behaviors|Input|Output|
|-----------|:-------:|:--------:|
|Application creates a monster instance|-|true|
|Application creates a person instance|- |true|
|Application adds a name to monster instance|Harry|Harry|


## Routes
|Behavior|Path|HTTP Verb|App.Java Example|
|-----------|:-------:|:--------:|:--------|
|Home page|/|GET|get("/", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); model.put("template", "templates/index.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|List all objects|/`people`|GET|get("/`people`", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); model.put("`people`", request.session().attribute("`people`")); model.put("template", "templates/`people`.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|List all objects|/`monsters`|GET|get("/`monsters`", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); model.put("`monsters`", request.session().attribute("`monsters`")); model.put("template", "templates/`monsters`.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|Display specific object's details|/`people`/:id|GET|get("/`people`/:id", (request, respond) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); `Person` `person` = `Person`.find(Integer.parseInt(request.params(":id"))); model.put("`person`", `person`); model.put("template", "templates/`person`.vtl"); Return new ModelAndView(model, layout);}, new VelocityTemplateEngine());|
|Display specific object's details|/`monsters`/:id|GET|get("/`monsters`/:id", (request, respond) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); `Monsers` `monsters` =monsters `Monsers`.find(Integer.parseInt(request.params(":id"))); model.put("`monsters`", `monsters`); model.put("template", "templates/`monsters`.vtl"); Return new ModelAndView(model, layout);}, new VelocityTemplateEngine());|
|Display form|/`people`/new|GET|get("`people`/new", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); model.put("template", "templates/`person`-form.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|Display form|/`monsters`/new|GET|get("`monsters`/new", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); model.put("template", "templates/`monster`-form.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|Create new object when form is submitted|/`people`|POST|post("/`people`", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); String name = request.queryParams("name"); `Person` `newPerson` = new `Person`(name);   model.put("template", "templates/`success`.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|
|Create new object when form is submitted|/`monsters`|POST|post("/`monsters`", (request, response) -> { Map`<String, Object>` model = new HashMap`<String, Object>`(); String name = request.queryParams("name"); `Monster` `newMonster` = new `Monster`(name);   model.put("template", "templates/`success`.vtl"); return new ModelAndView(model, layout); }, new VelocityTemplateEngine());|



## License
*GPL*
Copyright (c) 2017 **_Grace Stuart_**
