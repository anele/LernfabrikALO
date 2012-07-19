class Photo < ActiveRecord::Base
  attr_accessible :image_description, :image_name, :image_type
end
