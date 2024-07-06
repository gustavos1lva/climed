create table if not exists doenca
(
    id_doenca   serial primary key,
    nome_doenca varchar(50) not null
);

create table if not exists paciente
(
    id_pac       serial primary key,
    cpf          varchar(20) unique,
    nome_pac     varchar(50)        not null,
    telefone_pac varchar(20) unique not null,
    endereco     varchar(100),
    idade        int,
    sexo         varchar(20)
);

create table if not exists medico
(
    crm             int primary key,
    nome_medico     varchar(50) not null,
    telefone_medico varchar(20) not null unique,
    percentual      real        not null
);

create table if not exists agenda
(
    id_agenda   serial primary key,
    dia_semana  int  not null,
    hora_inicio time not null,
    hora_fim    time not null,
    crm         int references medico (crm) on delete cascade
);

create table if not exists especialidade
(
    id_esp   serial primary key,
    nome_esp varchar(50) not null,
    indice   varchar(50)
);

create table if not exists exerce_esp
(
    crm    int references medico (crm) on delete cascade,
    id_esp int references especialidade (id_esp) on delete cascade
);


create table if not exists consulta
(
    id_con          serial primary key,
    crm             int references medico (crm) on delete cascade,
    id_esp          int references especialidade (id_esp) on delete cascade,
    id_pac          int references paciente (id_pac) on delete cascade,
    data            date      not null,
    hora_inic_con   timestamp not null,
    hora_fim_con    timestamp,
    pagou           boolean default false,
    valor_pago      numeric(10, 2),
    forma_pagamento varchar(50)
);

create table if not exists diagnostico
(
    id_diagnostico         serial primary key,
    tratamento_recomendado varchar(200),
    remedios_receitados    varchar(200),
    observacoes            text,
    id_con                 int references consulta (id_con) on delete cascade
);

create table if not exists diagnostica
(
    id_diagnostica serial primary key,
    id_diagnostico int references diagnostico (id_diagnostico) on delete cascade,
    id_doenca      int references doenca (id_doenca) on delete cascade
);

