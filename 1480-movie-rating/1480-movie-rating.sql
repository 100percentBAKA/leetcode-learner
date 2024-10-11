with all_merge as (
    select a.title, b.name, c.rating, c.created_at
    from MovieRating c
    join Movies a on a.movie_id = c.movie_id
    join Users b on b.user_id = c.user_id
),

-- select * from all_merge;

person as (
    select
        name, count(*) as ratings_given
    from 
        all_merge
    group by
        name
    order by
        ratings_given desc, name asc
    limit
        1
),

movie as (
    select 
        title, avg(rating) as avg_rating
    from 
        all_merge
    where
        created_at between '2020-02-01' and '2020-02-29'
    group by
        title
    order by
        avg_rating desc, title asc
    limit
        1
)

select name as results from person
union all
select title as results from movie;
