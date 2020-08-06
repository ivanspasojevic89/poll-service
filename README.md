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
      
Decision for this assignment would be PostgreSQL, but for project it would be needed deep research and analyse.
