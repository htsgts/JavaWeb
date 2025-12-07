create table tbl_attach
(
	UUID		varchar(100) not null,
	uploadpath	varchar(200) not null,
	filename	varchar(100) not null,
	image		varchar(1),  /* image 1, not 0 */
	bno			int(10)
);

alter table tbl_attach
add constraint primary key(uuid);

select *
from   tbl_attach
;