# Poll service

### Implementation


#### MongoDB vs PostgreSQL decision
MongoDB pros:

    - One collection with all poll details (poll with nested objects)
    - Based on data from asset.json, no specific schema, attributes can vary from object to object
    - Better search results - query only one collection with/ or without projection
    - Possible support for reactive, non-blocking API for large number of polls

MongoDB cons:

    - No relationship between option and user - backend system would not be able to identify which user (or how many of them) votes for specific option
    - less-performant inserts/updates with possible concurency issues - every insert/update of participant/invitee of poll will affect the same document (poll)
    - Applicable, but not clean to be master system of users and enforce security via token. In case this DB is planned to be master system for user data, we will have either duplication of user data on poll collection, either relationships between user and poll

PostgreSQL pros:

    - Easy to implement relationship, if this backend would have in future role to wire option with user
    - Can support schemaless to the some level, using jsonb, arrays and other types
    - Easy to implement security, to be master system for user and wire user to poll
    - Better insert performance for participants and invitees (simple insert to one table, without concurency issues)
    
PostgreSQL cons:

    - Less performant search details (joins with another tables)
    - There is no strictly defined schema we can rely on
      
Decision for this assignment would be PostgreSQL in order to have possibility to relate user (participant) with option, but for project it would be needed deep research and analyse.

###DB model
Based on sample file, there are several tables in PostgreSQL database - User, Poll, Option, Invitee and UserVote (relation between participant and option).

###API
There are 3 APIs for searching Poll. APIs which should return more contact in the list are returning PollSummary (Only necessary information from Poll table).
For PollDetails (with options, participant and invitees) it should be fetched only one poll for the  performance reasons

###TODO 

In this assignment offset are used just as show case. Offset in queries would not be used since they have a really poor performance for larger offsets and provide possible duplications or skips some rows based on new inserts/deletions.


 - Database:
    - Review decision about PostgreSQL/MongoDB/... based on more information
    - Review current model - add/predict more optionTypes, add more data in existing tables if necessary (Option table, UserVote table with answer data)
    - Review indexes and execution plans on predictable number of data
   
    
 - APIs and code:
    - Review if security needed (OAuth maybe) and move user details from body to security token. Review if session beans needed.
    - Add validation to api (currently only tested happy path). Every single request should be validated and error messages should be returned.
    - Add validation on hibernate level (to avoid Not null constraint on database)
    - Review current hibernate model and queries to avoid N+1 query to database
    - Refactor current model-dto transformation (using Dozer, or any other mapper)
    - Generate swagger and add swagger page for API documentation
 - Tests:
    - Make unit test or api test in order to increase code coverage and mocks to test transformation between model and DTOs.

 - Docker:
    This is simple docker and docker compose just as show case. It should in volumes skip some files which are too big and unnecessary from docker, so compose may take several minutes.
    Override postgresql user and password data.