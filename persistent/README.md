# To create ES products index along with product mapping run the following curl command

#Command
curl -XPUT '/path/to/es/uri:port/products/' --data @/path/to/data/file

#e.i: curl -XPUT 'localhost:9200/products/' --data @./product_index.json


Bulk data Command
curl -s -XPUT localhost:9200/_bulk --data-binary "@requests"; echo

#e.i: curl -XPUT 'localhost:9200/_bulk?pretty' --data-binary @./persistent/product_sample_data.json


#Elasticsearch docker image url:
https://hub.docker.com/_/elasticsearch/

#ES Docker image run command
docker run -p 9200:9200 -p 9300:9300 -d elasticsearch