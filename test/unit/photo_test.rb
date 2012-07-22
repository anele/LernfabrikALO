require 'test_helper'

class PhotoTest < ActiveSupport::TestCase
  test "should create a new photo" do
    photo = Photo.new(:image_description =>"S",
    :image_name =>"S_1.png", :image_type =>1)
    assert photo.save
  end

  test "should not create a new photo" do
    photo = Photo.new(:image_description =>"S",
    :image_name =>"S_1.png", :image_type =>21)
    assert !photo.save, "validates_length_of: image_type"
  end

  test "should be 6" do
    assert_equal 6, Photo.count
  end

  test "should find a photo" do
    assert Photo.find(:first)
  end

  test "should find 2 photos" do
    photo1 = Photo.find(:first)
    photo2 = Photo.find(:last)
    assert_not_same( photo1, photo2)
  end

  test "should destroy a photo" do
    Photo.find(:first).destroy
    assert_equal 5, Photo.count
  end

  test "should require uniqueness of an image name" do
    photo1 = Photo.new(:image_name => "P_1.png",
    :image_description => "P", :image_type => 1)
    photo2 = Photo.new(:image_name => "P_2.png",
    :image_description => "P", :image_type => 2)
    assert photo1.save
    assert photo2.save
  end

  test "should create a valid photo" do
    photo = Photo.new(valid_photo_attribute)
    assert photo.save
  end

  test "should create a valid photo require name" do
    photo = Photo.new(valid_photo_attribute(:image_name =>nil))
    assert !photo.save, "image_name is missing"
  end

  test "should create a photo with required name legth" do
    photo = Photo.new(valid_photo_attribute(:image_name =>"TS_1.png"))
    assert !photo.save, "image_name is too long"
  end

  test "should create a unique photo" do
    photo1 = Photo.new(valid_photo_attribute)
    assert photo1.save

    photo2 = Photo.new(valid_photo_attribute)
    assert !photo2.save
  end

end

