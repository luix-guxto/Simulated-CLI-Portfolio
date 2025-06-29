insert
	into
	cli_portfolio.academic
(course_pt,
	course_en,
	organization,
	start_date,
	end_date,
	status)
values (:course_pt,
:course_en,
:organization,
STR_TO_DATE(:start_date, '%d/%m/%Y'),
STR_TO_DATE(:end_date, '%d/%m/%Y'),
:status);


select * from academic

insert
	into
	cli_portfolio.work_experience
(company,
	company_url,
	start_date,
	end_date,
	role_pt,
	role_en,
	location,
	is_current,
	description_pt,
	description_en)
values (:company,
:company_url,
STR_TO_DATE(:start_date, '%d/%m/%Y'),
STR_TO_DATE(:end_date, '%d/%m/%Y'),
:role_pt,
:role_en,
:location,
:is_current,
:description_pt,
:description_en);

select * from work_experience

insert
	into
	cli_portfolio.category
(skill)
values (:skill);

select * from category

insert
	into
	cli_portfolio.project
(name_pt,
	name_en,
	description_pt,
	description_en,
	url)
values (:name_pt,
:name_en,
:description_pt,
:description_en,
:url);

select * from project

insert
	into
	cli_portfolio.certificate
(name_pt,
	name_en,
	organization,
	issue_date,
	expiration_date,
	description_pt,
	description_en,
	code,
	url)
values (:name_pt,
:name_en,
:organization,
STR_TO_DATE(:issue_date, '%d/%m/%Y'),
STR_TO_DATE(:expiration_date, '%d/%m/%Y'),
:description_pt,
:description_en,
:code,
:url);

select * from certificate

insert
	into
	cli_portfolio.language
(name_pt,
	name_en,
	level_reading,
	level_writing,
	level_speaking)
values (:name_pt,
:name_en,
:level_reading,
:level_writing,
:level_speaking);

select * from language

insert
	into
	cli_portfolio.knowledge
(name_pt,
	name_en,
	level,
	url)
values (:name_pt,
:name_en,
:level,
:url);

select * from knowledge

insert
	into
	cli_portfolio.profile
(name,
	title_pt,
	title_en,
	bio_pt,
	bio_en,
	email,
	phone,
	location,
	linkedin,
	github,
	cv_pt_url,
	cv_en_url)
values (:name,
:title_pt,
:title_en,
:bio_pt,
:bio_en,
:email,
:phone,
:location,
:linkedin,
:github,
:cv_pt_url,
:cv_en_url);

SELECT JSON_OBJECT(
  'id', id,
  'name', name,
  'title_pt', title_pt,
  'title_en', title_en,
  'bio_pt', bio_pt,
  'bio_en', bio_en,
  'email', email,
  'phone', phone,
  'location', location,
  'linkedin', linkedin,
  'github', github,
  'cv_pt_url', cv_pt_url,
  'cv_en_url', cv_en_url
) AS profile_json
FROM profile;



-- Categories relationship

insert
	into
	cli_portfolio.project_category
(project_id,
	category_id)
values (:project_id,
:category_id);

select * from project_category

SELECT 
  p.id,
  p.name_pt,
  p.name_en,
  p.description_pt,
  p.description_en,
  p.url,
  GROUP_CONCAT(c.skill ORDER BY c.skill SEPARATOR ', ') AS skills
FROM project p
LEFT JOIN project_category pc ON p.id = pc.project_id
LEFT JOIN category c ON pc.category_id = c.id
GROUP BY p.id, p.name_pt, p.name_en, p.description_pt, p.description_en, p.url;

insert
	into
	cli_portfolio.knowledge_category
(knowledge_id,
	category_id)
values (:knowledge_id,
:category_id);

SELECT 
  k.id,
  k.name_pt,
  k.name_en,
  k.level,
  k.url,
  GROUP_CONCAT(c.skill ORDER BY c.skill SEPARATOR ', ') AS skills
FROM knowledge k
LEFT JOIN knowledge_category kc ON k.id = kc.knowledge_id
LEFT JOIN category c ON kc.category_id = c.id
GROUP BY k.id, k.name_pt, k.name_en, k.level, k.url;

insert
	into
	cli_portfolio.certificate_category
(certificate_id,
	category_id)
values (:certificate_id,
:category_id);

SELECT 
  c.id,
  c.name_pt,
  c.name_en,
  c.organization,
  c.issue_date,
  c.expiration_date,
  c.description_pt,
  c.description_en,
  c.code,
  c.url,
  GROUP_CONCAT(cat.skill ORDER BY cat.skill SEPARATOR ', ') AS skills
FROM certificate c
LEFT JOIN certificate_category cc ON c.id = cc.certificate_id
LEFT JOIN category cat ON cc.category_id = cat.id
GROUP BY 
  c.id, c.name_pt, c.name_en, c.organization,
  c.issue_date, c.expiration_date, c.description_pt,
  c.description_en, c.code, c.url;