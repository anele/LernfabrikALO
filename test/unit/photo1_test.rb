require 'test_helper'

class Photo1Test < ActiveSupport::TestCase
  test "should create a new number" do
    number = Photo1.new(:image_description =>"vier",
    :image_name =>"vier_1.png", :image_type =>1)
    assert number.save
  end

  test "should not create a new number" do
    number = Photo1.new(:image_description =>"eins",
    :image_name =>"eins_1.png", :image_type =>21)
    assert !number.save, "validates_length_of: image_type"
  end

  test "should be 6" do
    assert_equal 6, Photo1.count
  end

  test "should find a number" do
    assert Photo1.find(:first)
  end

  test "should find 2 numbers" do
    number1 = Photo1.find(:first)
    number2 = Photo1.find(:last)
    assert_not_same( number1, number2)
  end

  test "should destroy a number" do
    Photo1.find(:first).destroy
    assert_equal 5, Photo1.count
  end

  test "should require uniqueness of an number name" do
    number1 = Photo1.new(:image_name => "sechs_1.png",
    :image_description => "sechs", :image_type => 1)
    number2 = Photo1.new(:image_name => "sieben_2.png",
    :image_description => "sieben", :image_type => 2)
    assert number1.save
    assert number2.save
  end

  test "should create a valid number" do
    number = Photo1.new(valid_number_attribute)
    assert number.save
  end

  test "should create a valid number require name" do
    number = Photo1.new(valid_number_attribute(:image_name =>nil))
    assert !number.save, "image_name is missing"
  end

  test "should create a photo with required name legth" do
    number = Photo.new(valid_number_attribute(:image_name =>"siebenn_1.png"))
    assert !number.save, "image_name is too long"
  end

  test "should create a unique number" do
    number1 = Photo1.new(valid_number_attribute)
    assert number1.save

    number2 = Photo1.new(valid_number_attribute)
    assert !number2.save
  end
end
