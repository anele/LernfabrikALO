class CreatePhoto1s < ActiveRecord::Migration
  def change
    create_table :photo1s do |t|
      t.string :image_name
      t.string :image_description
      t.integer :image_type

      t.timestamps
    end
  end
end
