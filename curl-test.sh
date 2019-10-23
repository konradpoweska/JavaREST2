curl -X POST "http://localhost:9000/data" -d "nom=toto"
echo # (to split lines)

curl -X GET "http://localhost:9000/data?nom=toto"
echo # (to split lines)

curl -X PUT "http://localhost:9000/data" -d "nom=toto"
echo # (to split lines)

curl -X DELETE "http://localhost:9000/data?nom=toto"
echo # (to split lines)
