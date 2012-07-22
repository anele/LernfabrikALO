class Photo < ActiveRecord::Base
  attr_accessible :image_name
  attr_accessible :image_description
  attr_accessible :image_type
  
  validates_length_of :image_name, :is => 7
  validates_length_of :image_description, :is => 1
  validates_length_of :image_type, :is => 1
  
  validates_presence_of :image_name
  validates_presence_of :image_description
  validates_presence_of :image_type
  
  validates_uniqueness_of :image_name
end
