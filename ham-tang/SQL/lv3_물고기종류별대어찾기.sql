# -- 코드를 작성해주세요
select fi.ID, fni.FISH_NAME, fi.LENGTH 
from FISH_INFO fi join FISH_NAME_INFO fni on fi.fish_type = fni.fish_type
where (fi.FISH_TYPE, fi.LENGTH) in (
    select FISH_TYPE, max(LENGTH)
    from FISH_INFO
    group by FISH_TYPE
)
order by fi.id
