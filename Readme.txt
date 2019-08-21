Test Document for Event_Orgaizer API

1. Create

URI - http://localhost:9090/event/add
http Method  - POST
Parameters required - 

id - long integer unique
title - min 1 and max 50 char
description - min 1 and max 1000 chars
startDateTime - format is (MM/dd/yyyy hh:mm:ss)
endDateTime - format is (MM/dd/yyyy hh:mm:ss)
category - allowed only ("PERSONAL. BUSINESS, OTHERS")

2. Update

URI - http://localhost:9090/event/update
http Method  - PUT
Parameters required - 

id - long integer unique
title - min 1 and max 50 char
description - min 1 and max 1000 chars
startDateTime - format is (MM/dd/yyyy hh:mm:ss)
endDateTime - format is (MM/dd/yyyy hh:mm:ss)
category - allowed only ("PERSONAL. BUSINESS, OTHERS")


3. Delete

URI - http://localhost:9090/event/delete/{regdId}
http Method  - DELETE
Parameters required - 

regdId - id of the event which is unique

4. Sort

URI - http://localhost:9090/event/sort/{type}/{order}
http Method  - GET
Parameters required - 

type - title/description/startDateTime/endDateTime/category
order - asc/desc