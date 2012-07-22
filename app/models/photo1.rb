class Photo1 < ActiveRecord::Base
  attr_accessible :image_name
  attr_accessible :image_description
  attr_accessible :image_type
  
  validates_length_of :image_name, :maximum => 12
  validates_length_of :image_description, :maximum => 6, :message =>"should be no more than %d"
  validates_length_of :image_type, :is => 1
  
  validates_presence_of :image_name
  validates_presence_of :image_description
  validates_presence_of :image_type
  
  validates_uniqueness_of :image_name
end
