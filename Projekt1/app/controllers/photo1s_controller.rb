class Photo1sController < ApplicationController
  # GET /photo1s
  # GET /photo1s.json
  def index
   @photo1s = Photo1.find(:all, :order => "Random()")

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @photo1s }
    end
  end

  # GET /photo1s/1
  # GET /photo1s/1.json
  def show
    @photo1 = Photo1.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @photo1 }
    end
  end

  # GET /photo1s/new
  # GET /photo1s/new.json
  def new
    @photo1 = Photo1.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @photo1 }
    end
  end

  # GET /photo1s/1/edit
  def edit
    @photo1 = Photo1.find(params[:id])
  end

  # POST /photo1s
  # POST /photo1s.json
  def create
    @photo1 = Photo1.new(params[:photo1])

    respond_to do |format|
      if @photo1.save
        format.html { redirect_to @photo1, notice: 'Photo1 was successfully created.' }
        format.json { render json: @photo1, status: :created, location: @photo1 }
      else
        format.html { render action: "new" }
        format.json { render json: @photo1.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /photo1s/1
  # PUT /photo1s/1.json
  def update
    @photo1 = Photo1.find(params[:id])

    respond_to do |format|
      if @photo1.update_attributes(params[:photo1])
        format.html { redirect_to @photo1, notice: 'Photo1 was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @photo1.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /photo1s/1
  # DELETE /photo1s/1.json
  def destroy
    @photo1 = Photo1.find(params[:id])
    @photo1.destroy

    respond_to do |format|
      format.html { redirect_to photo1s_url }
      format.json { head :no_content }
    end
  end
end
