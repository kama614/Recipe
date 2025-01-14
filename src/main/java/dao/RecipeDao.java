package dao;

import java.util.List;

import dto.Recipe;

public interface RecipeDao {
	List<Recipe> findAll() throws Exception; //全データを取得
	 
	Recipe findById(Integer id) throws Exception; //指定したidの情報を取得

	void add(Recipe recipe) throws Exception; //追加

	void update(Recipe recipe) throws Exception; //更新

	void delete(Recipe recipe) throws Exception; // 削除



}
