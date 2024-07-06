-- aleatorios

insert into medico (crm, nome_medico, telefone_medico, percentual)
select generate_series(1, 100)      as crm,
       generate_series(1, 100)      as nome_medico,
       floor(random() * 1000000000) as telefone_medico,
       random() * 100               as percentual;

insert into paciente (cpf, nome_pac, telefone_pac, endereco, idade, sexo)
select generate_series(1, 100)                                       as cpf,
       generate_series(1, 100)                                       as nome_pac,
       generate_series(101, 200)                                     as telefone_pac,
       generate_series(1, 100)                                       as endereco,
       floor(random() * 90) + 10                                     as idade,
       case when random() > 0.5 then 'Masculino' else 'Feminino' end as sexo;

insert into especialidade (nome_esp, indice)
select 'Especialidade ' || generate_series(1, 10) as nome_esp,
       'Índice ' || generate_series(1, 10)        as indice;

insert into exerce_esp (crm, id_esp)
select (random() * 99) + 1 as crm,
       (random() * 9) + 1  as id_esp
from generate_series(1, 100);

insert into doenca (nome_doenca)
select 'Doença ' || generate_series(1, 20) as nome_doenca;

insert into consulta (crm, id_esp, id_pac, data, hora_inic_con, hora_fim_con, pagou, valor_pago, forma_pagamento)
select (random() * 99) + 1                                           as crm,
       (random() * 9) + 1                                            as id_esp,
       (random() * 99) + 1                                           as id_pac,
       current_date - (random() * 365)::int                          as data,
       current_timestamp - ((random() * 3600) * interval '1 second') as hora_inic_con,
       current_timestamp                                             as hora_fim_con,
       random() > 0.5                                                as pagou,
       random() * 500                                                as valor_pago,
       case
           when random() > 0.5 then 'Cartão'
           else 'Dinheiro'
           end                                                       as forma_pagamento
from generate_series(1, 100);

insert into diagnostico (tratamento_recomendado, remedios_receitados, observacoes, id_con)
select 'Tratamento para Doença ' || (random() * 20) + 1         as tratamento_recomendado,
       'Remédio ' || generate_series(1, 3)                      as remedios_receitados,
       'Observações sobre consulta ' || generate_series(1, 100) as observacoes,
       (random() * 99) + 1                                      as id_con
from generate_series(1, 100);

insert into diagnostica (id_doenca)
SELECT (random() * 19) + 1 as id_doenca
FROM generate_series(1, 100);

-- questao 3-a

insert into especialidade (nome_esp, indice)
VALUES ('Cardiologia',
        8);

insert into medico (crm, nome_medico, telefone_medico, percentual)
VALUES (123456,
        'Dr. House',
        floor(random() * 1000000000),
        random() * 100);

insert into exerce_esp (crm, id_esp)
VALUES (123456, (select id_esp from especialidade where indice = '8'));

INSERT INTO paciente (cpf, nome_pac, telefone_pac, endereco, idade, sexo)
VALUES (floor(random() * 1000000000),
        'Diego Pituca',
        floor(random() * 1000000000),
        floor(random() * 1000000000),
        floor(random() * 90) + 10,
        'Masculino');

insert into consulta (crm, id_esp, id_pac, data, hora_inic_con, hora_fim_con, pagou, valor_pago, forma_pagamento)
select 123456,
       (select id_esp from especialidade where indice = '8')         as id_esp,
       (select id_pac from paciente where nome_pac = 'Diego Pituca') as id_pac,
       '2024-05-05'                                                  as data,
       '2024-05-05 14:00:00.000000'                                  as hora_inic_con,
       '2024-05-05 15:00:00.000000'                                  as hora_fim_con,
       true                                                          as pagou,
       300                                                           as valor_pago,
       'Cartão'                                                      as forma_pagamento
;

-- questao 3b)

insert into especialidade (nome_esp, indice)
VALUES ('Dermatologia',
        9);

insert into exerce_esp (crm, id_esp)
VALUES (123456, (select id_esp from especialidade where indice = '9'));

insert into medico (crm, nome_medico, telefone_medico, percentual)
VALUES (654321,
        'Dr. Kildare',
        floor(random() * 1000000000),
        random() * 100);

insert into exerce_esp (crm, id_esp)
VALUES (654321, (select id_esp from especialidade where indice = '9'));

-- questao 3c)

insert into medico (crm, nome_medico, telefone_medico, percentual)
VALUES (111111,
        'Dr. Knowitall',
        floor(random() * 1000000000),
        random() * 100);

insert into exerce_esp (crm, id_esp)
VALUES (1, generate_series(1, 12));

-- questao 3e)

insert into agenda (dia_semana, hora_inicio, hora_fim, crm)
select generate_series(0, 6)                                                 as dia_semana,
       current_time + make_interval(mins := (random() * 60)::int)::interval  as hora_inicio,
       current_time + make_interval(mins := (random() * 120)::int)::interval as hora_fim,
       123456                                                                as crm;

insert into agenda (dia_semana, hora_inicio, hora_fim, crm)
select generate_series(0, 5)                                                 as dia_semana,
       current_time + make_interval(mins := (random() * 60)::int)::interval  as hora_inicio,
       current_time + make_interval(mins := (random() * 120)::int)::interval as hora_fim,
       654321                                                                as crm;

-- questao 3j)

insert into consulta (crm, id_esp, id_pac, data, hora_inic_con, hora_fim_con, pagou, valor_pago, forma_pagamento)
select 123456,
       (select id_esp from especialidade where indice = '9')         as id_esp,
       (select id_pac from paciente where nome_pac = 'Diego Pituca') as id_pac,
       '2024-05-10'                                                  as data,
       '2024-05-10 10:00:00.000000'                                  as hora_inic_con,
       null,
       true                                                          as pagou,
       500                                                           as valor_pago,
       'Dinheiro'                                                    as forma_pagamento
;