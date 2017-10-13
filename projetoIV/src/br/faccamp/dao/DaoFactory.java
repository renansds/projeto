package br.faccamp.dao;

public interface DaoFactory {
		public boolean insert();
		public boolean delete();
		public boolean update();
		public boolean save();
		public boolean insert(String nome, String cpf, String login, String senha);
}
