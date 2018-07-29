```shell
# subscribe
curl -X POST \
  http://localhost:8080/subscribe \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "subscriber1",
    "callbackUrl": "http://localhost:8081/feed"
}'

# unsubscribe
curl -X POST \
  http://localhost:8080/unsubscribe \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "subscriber1",
    "callbackUrl": "http://localhost:8081/feed"
}'


# publish post
curl -X POST \
  http://localhost:8080/publish \
  -H 'Content-Type: application/json' \
  -d '{
    "author": "Bob",
    "title": "new Subscriber"
}'
```
