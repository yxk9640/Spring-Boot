# About
This folder contains redis implemented with node.


## Notes
Learn implementaiton of express and node server to fetch from a server.


## Node Setup
### Packages
`nodemon`: Monitor the changes in files and re-run the server.
`express`: connect server.
`cors`: cros-site scripting.
`axios`: initiate request to server/ can use fetch also.





## Redis Setup 

1. Redis stores data as key-value pairs.
2. Data types are not necessary to mention.
3. Install:
   - `$brew install redis`
   - `$npm i redis`

#### Starting Redis

a.

| Code                     |                |
|--------------------------|----------------|
| Start server             | `$brew services start redis` |
| Stop server              | `$brew services stop redis`  |

b.

| Code          |                |
|---------------|----------------|
| Start server  | `$redis-server`|

#### CLI

- `$redis-cli`

#### Queries

**Strings:**
- `$ SET <key> <value>`
- `$ GET <key>`
- `$ DEL <key>`

**Check for a key presence**
- `$ EXISTS <key>`
  - `-> 0: not present`
  - `-> 1: present`

**All keys**
- `$ KEYS *`

**Delete all keys**
- `$ FLUSHALL`

**Keys that expire**
- `$ EXPIRE <key> <expire-time>`

**Set keys that expire**
- `$ SETEX <key> <time-minutes> <value>`

**Arrays: Can be used to cache messages.**

**Set/create array elements**
- `$lpush <key> <value>`
  - `lpush`: Adds elements at left/start.
  - `rpush`: Adds elements at left/end.

**Get elements**
- `$lrange <array-key> <range-start> <range-end>`
  - `range-end: -1` (goes to the end of the array)

**Delete array elements**
- `$rpop`
- `$lpop`

**Set: Unique List**
- Use `s` at the start of the command

**Add/create**
- `$SADD <set-list-name> <values-space-separator>`

**Get**
- `$SMEMBERS`
  - What if multiple sets are present and we need to get one?

**Remove**
- `$SREM`

**Hashes: Store a value as key:value object (not nested key:value but just one object)**

**Example:**
- `person:key (name:key "Yogesh":value ):value`

**Set/Create**
- `$ HSET <key> <value as key> <value of inner-key>`

**Get**
- `$HGET <first-key> <second-key>`
  - Example: `$HGET person name`

**Get All values**
- `$HGETALL <key>`
