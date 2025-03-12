-- Criar tabela de notificações
CREATE TABLE notificacoes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usuario_id UUID NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    mensagem TEXT,
    tipo VARCHAR(50) CHECK (tipo IN ('EPI Vencendo','Uniforme Novo','Solicitação Aprovada','Solicitação Negada')),
    lida BOOLEAN DEFAULT FALSE,
    data_criacao TIMESTAMP DEFAULT NOW()
);