import requests
import re
from bs4 import BeautifulSoup
import csv

course_offering_plan = 'https://www.cics.umass.edu/content/course-offering-plan'
fall_22_schedule = 'https://www.cics.umass.edu/content/fall-22-course-schedule'

#Get Course Offering Data
f = open("./resources/course_data/Course_Offering_Plan.csv", mode = "w")
csvwriter = csv.writer(f)
resp = requests.get(course_offering_plan)
page = BeautifulSoup(resp.text, "html.parser")
tables = page.find_all("tbody")
for table in tables:
    trs = table.find_all("tr")[1:]
    for tr in trs:
        tds = tr.find_all("td")
        subject = tds[0].text
        number = tds[1].text
        title = tds[2].text
        credits = tds[3].text
        frequency = tds[4].text
        csvwriter.writerow([subject, number, title, credits, frequency])
f.close()

#Get Fall 22 Data
f = open("./resources/course_data/Fall_22.csv", mode = "w")
csvwriter = csv.writer(f)
resp = requests.get(fall_22_schedule)
page = BeautifulSoup(resp.text, "html.parser")
subject = 'unknown'
table = page.find("table")
trs = table.find_all("tr")
for tr in trs:
    td = tr.find_all("td")
    if len(td) == 0:
        subject = tr.find("th").text
    elif len(td) == 2:
        number = tr.find("td").find("a").text
        csvwriter.writerow([subject, number])
f.close()
    


