class CreatePhotos < ActiveRecord::Migration
  def change
    create_table :photos do |t|
      t.string :image_name
      t.string :image_description
      t.integer :image_type

      t.timestamps
    end
  end
end
