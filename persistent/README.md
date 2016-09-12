# To create ES products index along with product mapping run the following curl command

#Command
curl -XPUT '/path/to/es/uri:port/products/' --data @/path/to/data/file

#e.i: curl -XPUT 'localhost:9200/products/' --data @./product_index.json


Bulk data Command
curl -s -XPOST localhost:9200/_bulk --data-binary "@requests"; echo