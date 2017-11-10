from bs4 import BeautifulSoup
import urllib
import os
import re
import sys

data = urllib.urlopen(sys.argv[1])
soup = BeautifulSoup(data, "lxml")
image = soup.find('img', {'src' : re.compile(r'(jpg)$')})
if not os.path.exists(sys.argv[2].replace(":", " -").replace("/", "-")+"/"+sys.argv[3].replace(":", " -").replace("/", "-")):
    os.makedirs(sys.argv[2].replace(":", " -").replace("/", "-")+"/"+sys.argv[3].replace(":", " -").replace("/", "-"))
urllib.urlretrieve(image["src"].replace("galleries", "https://www.figurerealm.com/galleries").replace("thumb_", ""), filename=sys.argv[2].replace(":", " -").replace("/", "-")+"/"+sys.argv[3].replace(":", " -").replace("/", "-")+"/"+sys.argv[4].replace("$:", "").replace(":", " -").replace('"', "'").replace("/", "-").replace("?", "").replace("**", "2").replace("***", "3")+".jpg")
